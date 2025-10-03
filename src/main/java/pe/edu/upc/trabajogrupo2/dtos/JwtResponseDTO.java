package pe.edu.upc.trabajogrupo2.dtos;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public String getJwttoken() { return jwttoken; }

    public JwtResponseDTO(String jwttoken) {
        super();
        this.jwttoken = jwttoken;
    }
}