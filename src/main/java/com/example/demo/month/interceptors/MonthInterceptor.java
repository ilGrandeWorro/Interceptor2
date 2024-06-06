package com.example.demo.month.interceptors;

import com.example.demo.month.models.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Gennhaionen"),
            new Month(2, "February", "Febbraio", "Februarioen"),
            new Month(3, "March", "Marzo", "Marzonen"),
            new Month(4, "April", "Aprile", "Aprillen"),
            new Month(5, "May", "Maggio", "Maggioneenn"),
            new Month(6, "June", "Giugno", "Juneen")));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String monthNumber = request.getHeader("monthNumber");
            if(monthNumber==null||monthNumber.isEmpty()){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return true;
            }
            return true;
    }
}
