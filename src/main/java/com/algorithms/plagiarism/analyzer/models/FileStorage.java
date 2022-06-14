package com.algorithms.plagiarism.analyzer.models;

import com.algorithms.plagiarism.assignment.models.AssignmentModel;
import com.algorithms.plagiarism.assignment.models.StudentAssignment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToOne(mappedBy = "assignFile")
    @JsonBackReference
    private StudentAssignment assignmentList;

    @OneToOne(mappedBy = "referenceFile")
    @JsonBackReference
    private AssignmentModel refAssignment;
}
