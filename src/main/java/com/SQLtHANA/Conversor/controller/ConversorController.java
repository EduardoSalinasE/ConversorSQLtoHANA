package com.SQLtHANA.Conversor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ConversorController{

    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("/convert")
    public String convertSqlToHana(String sqlQuery, Model model) {
        String convertedQuery = convertToHanaQuery(sqlQuery);
        model.addAttribute("originalQuery", sqlQuery);
        model.addAttribute("convertedQuery", convertedQuery);
        return "index";
    }

    private String convertToHanaQuery(String sqlQuery) {
        // Reemplaza las funciones SQL por las equivalentes en HANA
        sqlQuery = replaceFunctions(sqlQuery);


        return sqlQuery;
    }

    private String replaceFunctions(String sqlQuery) {
        // Realiza aquí los reemplazos necesarios de funciones SQL por equivalentes en HANA
        sqlQuery = sqlQuery.replaceAll("(?i)ISNULL", "COALESCE");
        sqlQuery = sqlQuery.replaceAll("(?i)GETDATE", "CURRENT_TIMESTAMP");
        sqlQuery = sqlQuery.replaceAll("(?i)MONTH", "MONTHNAME");
        sqlQuery = sqlQuery.replaceAll("(?i)GETUTCDATE", "CURRENT_UTCTIMESTAMP");
        sqlQuery = sqlQuery.replaceAll("(?i)DATEDIFF", "DATEDIFF_SECONDS");
        sqlQuery = sqlQuery.replaceAll("(?i)GETDATE", "CURRENT_TIMESTAMP");
        sqlQuery = sqlQuery.replaceAll("(?i)GETDATE", "CURRENT_TIMESTAMP");
        sqlQuery = sqlQuery.replaceAll("(?i)LEN", "LENGTH");
        sqlQuery = sqlQuery.replaceAll("(?i)YEAR", "YEAR");
        sqlQuery = sqlQuery.replaceAll("(?i)SUM", "SUM");
        sqlQuery = sqlQuery.replaceAll("(?i)CONVERT", "CAST");
        sqlQuery = sqlQuery.replaceAll("(?i)UPPER", "UCASE");
        sqlQuery = sqlQuery.replaceAll("(?i)LOWER", "LCASE");
        sqlQuery = sqlQuery.replaceAll("(?i)LEFT", "LEFT");
        sqlQuery = sqlQuery.replaceAll("(?i)RIGHT", "RIGHT");
        sqlQuery = sqlQuery.replaceAll("(?i)ROUND", "ROUND");
        sqlQuery = sqlQuery.replaceAll("(?i)CEILING", "CEIL");
        sqlQuery = sqlQuery.replaceAll("(?i)FLOOR", "FLOOR");
        sqlQuery = sqlQuery.replaceAll("(?i)ABS", "ABS");
        sqlQuery = sqlQuery.replaceAll("(?i)POWER", "POWER");
        sqlQuery = sqlQuery.replaceAll("(?i)LOG", "LN");
        sqlQuery = sqlQuery.replaceAll("(?i)EXP", "EXP");
        sqlQuery = sqlQuery.replaceAll("(?i)SQRT", "SQRT");
        sqlQuery = sqlQuery.replaceAll("(?i)CHARINDEX", "POSITION");
        sqlQuery = sqlQuery.replaceAll("(?i)STUFF", "REPLACE");
        sqlQuery = sqlQuery.replaceAll("(?i)RTRIM", "RTRIM");
        sqlQuery = sqlQuery.replaceAll("(?i)LTRIM", "LTRIM");


        return sqlQuery;
    }


}

