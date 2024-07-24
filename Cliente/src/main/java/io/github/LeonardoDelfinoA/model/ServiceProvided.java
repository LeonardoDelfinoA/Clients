package io.github.LeonardoDelfinoA.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ServiceProvided {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Client client;
	
	@Column(name = "price")
	private BigDecimal value;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
}
