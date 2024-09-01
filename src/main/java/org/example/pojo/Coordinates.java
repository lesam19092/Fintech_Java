package org.example.pojo;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates implements Serializable {
    private double lat;
    private double lon;
}
