package com.algorithms.plagiarism.analyzer.models;

import com.algorithms.plagiarism.assignment.models.AssignmentModel;
import com.algorithms.plagiarism.assignment.models.StudentAssignment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "file_storage")
public class FileStorage {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long file_id;

    @Column(name = "file_name", nullable = false, length = 50)
    private String fileName;

    @Column(name = "file_uid", nullable = false, length = 50)
    private String fileUid;

    @Column(name = "original_url" , nullable = false)
    private String originalFileLink;

    @Column(name = "rendered_url" , nullable = false)
    private String renderedFileLink;

    @Column(name = "originality")
    private double originalityScore;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_uploaded")
    private Date dateUploaded;

    @ManyToOne
    @JsonManagedReference
    private FileStorage parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<FileStorage> plagiarized;

    @OneToOne(mappedBy = "assignFile", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private StudentAssignment assignmentList;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignmentId")
    private AssignmentModel assignment;
}
