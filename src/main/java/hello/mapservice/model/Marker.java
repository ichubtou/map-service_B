package hello.mapservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "marker")
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marker_id")
    private Integer markerId;

    @Column(name = "marker_category")
    private Integer markerCategory;

    @Column(name = "marker_inform")
    private String markerInform;

    @Column(name = "is_danger")
    private Integer isDanger;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "marker_longitude")
    private double markerLongitude;

    @Column(name = "marker_latitude")
    private double markerLatitude;

    @Column(name = "posting_day")
    private Date postingDay;

    @Column(name = "poster_nickname")
    private String posterNickName;

}

