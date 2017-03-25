import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rich1 on 9/12/16.
 */
public class UrlTest{

    Gson gson = new Gson();
    public static void main(String[] args){
       /* Map params = new HashMap<String,Object>();
        params.put("real_name","**");
        params.put("idcn","***");
        params.put("org_code","***");
        params.put("password","****");
        params.put("variate_list",null);

        String param = JSONObject.fromObject(params).toString();
        System.out.println(param);
        String url = "****";
        invoke(param, url);
        System.out.println("\n************************************");

        String[] s = {"**"};

        params.remove("variate_list");
        params.put("var_list",s);
        String param1 = JSONObject.fromObject(params).toString();
        System.out.println(param1);
        String url1 = "****";
        invoke(param1, url1);*/

        System.out.println("test get");
        try{
            get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=java%20http%20get%E8%AF%B7%E6%B1%82&oq=java%20http%E8%AF%B7%E6%B1%82&rsv_pq=fa40619200049b21&rsv_t=9af14B%2FHxMDOM0SNkRkL9j7AKFKtPdeXzfYnm7I8SxCuFLB1m4CArmHZO9A&rqlang=cn&rsv_enter=0&inputT=2619&rsv_sug3=182&rsv_sug1=174&rsv_sug7=100&rsv_sug2=0&rsv_sug4=3446");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void invoke(String params, String riskUrl){
        String result = "";

        try{
            URL url = new URL(riskUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(100000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            System.out.println("请求的参数为："+params);
            conn.getOutputStream().write(new String(params.getBytes(),
                    "utf-8").getBytes());

            System.out.print("返回的参数为：");
            int ch;
            while((ch = conn.getInputStream().read())!=-1){
                System.out.print((char)ch);
            }

        }catch (Exception e){
            System.out.println("出错："+e);
        }

    }

    public static void get(String url) throws Exception{
        System.out.println("请求url为:"+url);
        URL urlGet = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlGet.openConnection();
        con.setConnectTimeout(100000);
        con.setRequestProperty("Connection", "Keep-Alive");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestMethod("GET");
        //con.setDoInput(true);
        //con.setDoOutput(true);
        //con.connect();
        System.out.println("返回参数为:");
        int ch;
        while((ch = con.getInputStream().read()) != -1){
            System.out.print((char)ch);
        }
    }
}
