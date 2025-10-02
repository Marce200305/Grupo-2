package pe.edu.upc.trabajogrupo2.dtos;

public class CitaPorUsuarioDTO {

    public Integer id;
    private Long totalCitas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotalCitas() {
        return totalCitas;
    }

    public void setTotalCitas(Long totalCitas) {
        this.totalCitas = totalCitas;
    }
}
