package hib.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "games", schema = "ad")
public class GamesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "platform")
    private String platform;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "user_id")
    private Integer userId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesEntity that = (GamesEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(platform, that.platform) && Objects.equals(year, that.year) && Objects.equals(description, that.description) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, platform, year, description, userId);
    }
}
