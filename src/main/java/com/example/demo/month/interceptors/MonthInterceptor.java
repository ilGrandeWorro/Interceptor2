package com.example.demo.month.interceptors;

import com.example.demo.month.models.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Gennhaionen"),
            new Month(2, "February", "Febbraio", "Februarioen"),
            new Month(3, "March", "Marzo", "Marzonen"),
            new Month(4, "April", "Aprile", "Aprillen"),
            new Month(5, "May", "Maggio", "Maggioneenn"),
            new Month(6, "June", "Giugno", "Juneen")));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Prendo l'header monthNumber.
        String monthNumberString = request.getHeader("monthNumber");

        //Controllo che l'header non sia vuoto o nullo
        if (monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(400);
            return false;
        }

        //trasformo il valore dll'header in un intero
        int monthNumber = Integer.parseInt(monthNumberString);

        /*passo in rassegna la lista dei mesi salvati e prendo il primo il cui numero del mese corrisponde
        al numero dell'header*/
        Month month = monthList.stream().
                filter(listedMonth -> listedMonth.getMonthNumber() == monthNumber)
                .findFirst().
        //Nel caso non lo trovassi, passo un mese vuoto con i nomi forzati a "nope" come su richiesta
                orElseGet(() -> {
                    Month listedMonth = new Month();
                    listedMonth.setEnglishName("nope");
                    listedMonth.setItalianName("nope");
                    listedMonth.setGermanName("nope");
                    return listedMonth;
                });
        //faccio tornare il risultato (che sia in lista o vuoto) e passo la risposta come positiva
            request.setAttribute("month", month);
            response.setStatus(200);
        return true;
    }
}
