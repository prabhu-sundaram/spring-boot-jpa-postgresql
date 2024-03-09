package com.dm.springbootjpapostgresql.model.montaji;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "requestCPIPBuilder")
@Entity
@Table(name = "req_cpip")
@PrimaryKeyJoinColumn(name = "request_number")
public class RequestCPIP extends Request{
	// @Id  
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id", nullable = false)
	// private Long id;    
    
    private String consignmentPurposeId;   

    @OneToOne(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReqPortDetails reqPortDetails;

    @OneToMany(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Container> containers;    

    @OneToOne(mappedBy = "requestCPIP", cascade = CascadeType.ALL, orphanRemoval = true)
    private PreApproval preApproval;    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_number", nullable = false)
    private Request request;
}

