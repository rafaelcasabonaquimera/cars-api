package br.com.pitang.carsapi.user.framework.output.hibernate.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "_USER")
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    @Id
    @Column(name = "CD_USER")
    @GeneratedValue
    private Integer id;

    @Column(name = "NM_FIRST_NAME")
    private String firstName;

    @Column(name = "NM_LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DT_BIRTHDAY")
    private String birthday;

    @Column(name = "DS_LOGIN")
    private String login;

    @Column(name = "DS_PASSWORD")
    private String password;

    @Column(name = "NM_PHONE")
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CarData> cars;

}
