package org.example.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {
    private String slug;
    private Coordinates coords;
}
