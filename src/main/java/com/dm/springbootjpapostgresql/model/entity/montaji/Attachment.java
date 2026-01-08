package com.dm.springbootjpapostgresql.model.entity.montaji;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Clob;

import com.dm.springbootjpapostgresql.utils.StringToClobConverter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "attachment")
public class Attachment {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;     
    private String attachmentType;
    private String fileName;
    private String fileType;  
    //@Convert(converter = StringToClobConverter.class)
    private Clob fileContent;    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private Request request;          
}
