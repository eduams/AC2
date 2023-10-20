package com.ac2.ac2.exceptions;
import java.util.*;
import lombok.Getter;
public class ApiErrors {
@Getter
private List<String> errors;
public ApiErrors(String mensagemErro) {
errors = Arrays.asList(mensagemErro);
}
}