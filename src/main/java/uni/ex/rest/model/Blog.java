package uni.ex.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
public class Blog extends uni.ex.rest.model.AuditModel {

    @Id
    @GeneratedValue(generator = "blog_generator")
    @SequenceGenerator(
            name = "blog_generator",
            sequenceName = "blog_sequence",
            initialValue = 10
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String text;

    @Column(columnDefinition = "text")
    private String tag;

    @Column(columnDefinition = "text")
    private String author;
}
