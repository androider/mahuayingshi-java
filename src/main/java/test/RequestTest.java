package test;


import core.AesUtil;
import core.AppInfo;
import core.HeaderInfo;
import okhttp3.*;
import okhttp3.internal.http.HttpHeaders;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Author: liuqiang
 * Date: 2018-12-21
 * Time: 09:50
 * Description:
 */
public class RequestTest {


    public static void main(String[] args) {
        httpTest();
    }

    public static void httpTest() {

        final AppInfo appInfo = new AppInfo();

        final String url = "http://api.hbzjmf.com/api/app/member/ver2/user/login/2/7?uuid=862629030227329&model=EVA-AL10Android%207.0";

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String path = request.url().uri().getPath();

                        String encryptToHex = AesUtil.encryptToHex(appInfo.getEncryptPackageId(), AesUtil.getKey(true));
                        HeaderInfo createHeaderInfo = appInfo.createHeaderInfo(path);

                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(url);
                        stringBuilder3.append(url.contains("?") ? "&" : "?");
                        stringBuilder3.append("time=");
                        stringBuilder3.append(System.currentTimeMillis());


                        Request newRequest = request.newBuilder()
                                .url(stringBuilder3.toString())
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .header("accessToken", encryptToHex)
                                .header("X-Client-NonceStr", createHeaderInfo.getXClientNonceStr())
                                .header("X-Client-IP", createHeaderInfo.getXClientIP())
                                .header("X-Client-TimeStamp", createHeaderInfo.getXClientTimeStamp())
                                .header("X-Client-Version", createHeaderInfo.getXClientVersion())
                                .header("X-Client-Sign", createHeaderInfo.getXClientSign())
                                .header("X-Client-Token", "")
                                .header("X-Auth-Token", createHeaderInfo.getXAuthToken()).build();
                        return chain.proceed(newRequest);
                    }
                })
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        //异步请求，虽然是异步但是这个回调在子线程中执行
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.err.println("Q_M: 请求错误" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String decryptHex = AesUtil.decryptHex(response.body().string(), AesUtil.getKey(false));

                System.out.println("Q_M:" + decryptHex);
            }
        });
    }
}
