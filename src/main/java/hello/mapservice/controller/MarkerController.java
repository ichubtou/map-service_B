package hello.mapservice.controller;


import hello.mapservice.model.Marker;
import hello.mapservice.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MarkerController {

    @Autowired
    private MarkerService markerService;

    //get all Marker
    @GetMapping("/marker")
    public List<Marker> getAllMarkers() {
        return markerService.getAllMarker();
    }

    //create Marker
    @PostMapping("/marker")
    public Marker createMarker(@RequestBody Marker marker) {
        return markerService.createMarker(marker);
    }

    //get marker
    @GetMapping("/marker/{id}")
    public Marker getMarkerById(@PathVariable Integer id) {
        return markerService.getMarker(id);
    }

    //update marker
    @PutMapping("/marker/{id}")
    public ResponseEntity<Marker> updateMarkerById(@PathVariable Integer id, @RequestBody Marker marker) {
        return markerService.updateMarker(id, marker);
    }

    //delete marker
    @DeleteMapping("/marker/{id}")
    public void deleteMarkerById(@PathVariable Integer id) {
        markerService.deleteMarker(id);
    }

    //display image
    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        File file = new File("/Users/kimminsoo/Downloads/map-service/src/main/resources/static/image/" + fileName);

        ResponseEntity<byte[]> result = null;

        try {
            HttpHeaders header = new HttpHeaders();
            header.add("Content-type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //delete image
    @GetMapping("/delete/{fileName}")
    public void deleteFileByFileName(@PathVariable String fileName) {
        File file = new File("/Users/kimminsoo/Downloads/map-service/src/main/resources/static/image/" + fileName);

        if(file.exists()) {
            file.delete();
        }
    }

    
}
