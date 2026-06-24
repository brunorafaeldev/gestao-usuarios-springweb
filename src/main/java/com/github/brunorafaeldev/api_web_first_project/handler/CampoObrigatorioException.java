package com.github.brunorafaeldev.api_web_first_project.handler;

public class CampoObrigatorioException extends BusinessException {
    public CampoObrigatorioException(String campo) {
        super("O campo %s é obrigatório", campo);
    }

}
