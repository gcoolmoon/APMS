package edu.mum.apms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.apms.model.Release;
import edu.mum.apms.model.Sprint;
import edu.mum.apms.service.ReleaseService;

@RestController
public class ReleaseRestController {


	@Autowired
	ReleaseService releaseService;
	
	
	@RequestMapping("/restreleases")
    public List<Release> releases() {
        return releaseService.getAll();
    }
	
	@RequestMapping("/restrelease/{id}")
    public Release release(@PathVariable("id") int id) {
        return releaseService.get(id);
    }
	
	@RequestMapping("/restsprintbyrelease/{id}")
    public List<Sprint> sprintByRelease(@PathVariable("id") int id) {
		
        return releaseService.get(id).getSprint() ;
    }
}
