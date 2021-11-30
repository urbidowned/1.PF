package Urban.Projekt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.stream.Collectors;


@RestController
    public class ExchangeController {




        @GetMapping("/test")
        public String test(@RequestParam(value = "usedb", defaultValue = "false") String usedb) throws IOException {

            System.out.println("prislo: " + usedb);
            if(usedb.equals("true")){
                String tmp = todayValues().getContent();
                System.out.println(tmp);
                return tmp;
                //Naloadovat databazi
             //   podle datumu ukladat do databaze
            }else {
                //Pouzij posledni listky listky
            }
            return "";
            //return "{\"responseText\" : \"Ahoj\"}";
            //return new Exchange(new Date(), "Ahoj");
         //   return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
        public Exchange todayValues() throws IOException {
            URL url = new URL("https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int resCode = conn.getResponseCode()  ;
            BufferedReader br = null;
            if(100<=resCode && resCode<400){

                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String exchangeRates =  br.lines().collect(Collectors.joining());
            return new Exchange(new Date(), exchangeRates);
        }

    }

