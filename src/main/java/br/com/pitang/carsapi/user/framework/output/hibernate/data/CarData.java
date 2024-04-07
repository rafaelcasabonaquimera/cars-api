package br.com.pitang.carsapi.user.framework.output.hibernate.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CAR")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CarData {

    @Id
    @Column(name = "CD_CAR")
    @GeneratedValue
    private Integer id;

    @Column(name = "NR_YEAR")
    private Integer year;

    @Column(name = "DS_LICENSE_PLATE")
    private String licensePlate;

    @Column(name = "DS_MODEL")
    private String model;

    @Column(name = "DS_COLOR")
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserData user;

}
