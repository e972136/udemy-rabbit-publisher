package com.udemy.rabbit.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class ObjetoIntercambio implements Serializable {
    Integer id;
    String message;
}
