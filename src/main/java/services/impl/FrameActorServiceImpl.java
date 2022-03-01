package services.impl;

import controllers.FrameActorController;
import dtos.CreateFrameActor;
import dtos.UpdateFrameActor;
import entity.FrameActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repositories.FrameActorRepository;
import services.FrameActorService;

public class FrameActorServiceImpl implements FrameActorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FrameActorController.class);

    @Autowired
    private FrameActorRepository frameActorRepository;

    @Override
    public Page<FrameActor> getFrameActors(Pageable pageable) {
        return frameActorRepository.findAll(pageable);
    }

    @Override
    public FrameActor findFrameActor(String id) throws Exception {
        return frameActorRepository.findById(id).orElseThrow(() -> new Exception(""));
    }

    @Override
    public FrameActor createFrameActor(CreateFrameActor payload) {

        FrameActor frameActor = new FrameActor();
        frameActor.setQuote(payload.getQuote());
        frameActor.setDescription(payload.getDescription());

        frameActor = frameActorRepository.save(frameActor);

        return frameActor;
    }

    @Override
    public FrameActor updateFrameActor(UpdateFrameActor payload) throws Exception {
        FrameActor frameActor = findFrameActor(payload.getId());

        frameActor.setQuote(payload.getQuote());
        frameActor.setDescription(payload.getDescription());

        frameActor = frameActorRepository.save(frameActor);
        return frameActor;
    }

    @Override
    public void deleteFrameActor(String id) {
        frameActorRepository.deleteById(id);
    }
}
