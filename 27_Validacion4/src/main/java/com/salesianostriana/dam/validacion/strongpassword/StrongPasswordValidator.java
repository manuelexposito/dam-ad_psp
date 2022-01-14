package com.salesianostriana.dam.validacion.strongpassword;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {
    private int min;
    private int max;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasNumber;
    private boolean hasAlpha;
    private boolean hasOther;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
       // ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        hasUpper = constraintAnnotation.hasUpper();
        hasLower = constraintAnnotation.hasLower();
        hasNumber = constraintAnnotation.hasNumber();
        hasAlpha = constraintAnnotation.hasAlpha();
        hasOther = constraintAnnotation.hasOther();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {


        List<Boolean> validadores = new ArrayList<>();

        if(hasUpper){
            hasAlpha = true;
            validadores.add(checkUppercase(password)) ;
        }

        else if(hasLower){
            hasAlpha = true;
            validadores.add(checkLowercase(password));
        }

        else if(password.length() >= min){
            return validadores.add(true);
        }

        else if(password.length() <= max){
            return validadores.add(true);
        }

        else if(hasNumber){
            validadores.add(checkNumbers(password));
        }

        else if(hasAlpha){
            validadores.add(checkAlpha(password));
        }

        else if(hasOther){
            validadores.add(checkOther(password));
        }
        System.out.printf("Tiene mayusculas: %s \n", checkUppercase(password));
        System.out.printf("Tiene minusculas: %s \n", checkLowercase(password));
        System.out.printf("Contraseña mayor: %s \n", password.length() >= min);
        System.out.printf("Contraseña menor: %s \n", password.length() <= max);
        System.out.printf("Tiene números: %s \n", checkNumbers(password));
        System.out.printf("Tiene letras: %s \n", checkAlpha(password));
        System.out.printf("Tiene caracteres especiales: %s \n", checkOther(password));
        System.out.println("--------------------------------------------");
        System.out.printf("Validación final --> %s", (validadores.stream().allMatch(b -> true)));
        return validadores.stream().allMatch(b -> b);

    }


    private boolean checkOther(String word){

     //   String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}";
        char[] caracteres = word.toCharArray();
        StringBuilder contenedorCaracteres = new StringBuilder();

        for(char c : caracteres){

            if(!Character.isLetter(c) && !Character.isDigit(c)){
                contenedorCaracteres.append(c);
            }

        }

        return contenedorCaracteres.length() >= 1;

    }

    private boolean checkAlpha(String word){

        char[] caracteres = word.toCharArray();
        StringBuilder contenedorLetras = new StringBuilder();

        for( char letra : caracteres){

            if(Character.isLetter(letra)){
                contenedorLetras.append(letra);
            }

        }
        return contenedorLetras.length() >= 1;

    }


    private boolean checkNumbers(String word){

        char[] caracteres = word.toCharArray();
        StringBuilder numeros = new StringBuilder();

        for( char letra : caracteres){

            if(Character.isDigit(letra)){
                numeros.append(letra);
            }

        }
        return numeros.length() >= 1;

    }

    private boolean checkUppercase(String word) {

        char[] caracteres = word.toCharArray();
        StringBuilder mayusculas = new StringBuilder();

        for( char letra : caracteres){

            if(Character.isUpperCase(letra)){
                mayusculas.append(letra);
            }

        }
        return mayusculas.length() >= 1;
    }

    private boolean checkLowercase(String word){

        char[] caracteres = word.toCharArray();
        StringBuilder minusculas = new StringBuilder();

        for( char letra : caracteres){

            if(Character.isLowerCase(letra)){
                minusculas.append(letra);
            }

        }
        return minusculas.length() >= 1;


    }



}
