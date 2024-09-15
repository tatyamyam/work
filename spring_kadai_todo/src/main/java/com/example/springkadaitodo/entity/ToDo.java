package com.example.springkadaitodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    public enum Priority {
        HIGH("高"),
        MEDIUM("中"),
        LOW("低");

        private final String label;

        Priority(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
	
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
	
    public enum Status {
    	NOTSTARTED("未着手"),
    	INPROGRESS("着手中"),
    	COMPLETED("完了");
    	
    	private final String label;

        Status(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
