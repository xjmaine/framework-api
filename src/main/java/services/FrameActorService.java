package services;

import dtos.CreateFrameActor;
import dtos.UpdateFrameActor;
import entity.FrameActor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface FrameActorService {
	Page<FrameActor> getFrameActors(Pageable pageable);
	FrameActor findFrameActor(String id) throws Exception;
	FrameActor createFrameActor(CreateFrameActor payload);
	FrameActor updateFrameActor(UpdateFrameActor payload) throws Exception;
	void deleteFrameActor(String id);
}
