package controllers;

import dtos.CreateFrameActor;
import dtos.UpdateFrameActor;
import entity.FrameActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.FrameActorService;

import java.util.List;

@RestController
@RequestMapping(path = "/frame_actors")
public class FrameActorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FrameActorController.class);

	//@Autowired
	private final FrameActorService frameActorService;

	public FrameActorController(FrameActorService frameActorService) {
		this.frameActorService = frameActorService;
	}

	@GetMapping("/all")
	@ResponseBody
	public Page<FrameActor> listAllFrameActor(Pageable pageable) {

		Page<FrameActor> frameActorPage = frameActorService.getFrameActors(pageable);
		return frameActorPage;
	}

	@GetMapping("/search")
	@ResponseBody
	public Page<FrameActor> searchFrameActors(Pageable pageable) {

		Page<FrameActor> frameActorPage = frameActorService.getFrameActors(pageable);
		return frameActorPage;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public FrameActor getFrameActors(@PathVariable("id") String id) throws Exception {
		return frameActorService.findFrameActor(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public FrameActor createFrameActor(@RequestBody CreateFrameActor payload) {
		return frameActorService.createFrameActor(payload);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public FrameActor updateFrameActor(@RequestBody UpdateFrameActor payload) throws Exception {
		return frameActorService.updateFrameActor(payload);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public void deleteFrameActor(@PathVariable("id") String id) {
		frameActorService.deleteFrameActor(id);
	}

}
