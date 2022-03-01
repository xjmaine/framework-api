package dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class FrameActorDto {
	private String id;
	private String description;
	private float quote;
	private Date dateCreated;
	private Date dateModified;
}
