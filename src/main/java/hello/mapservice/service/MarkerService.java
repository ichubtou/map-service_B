package hello.mapservice.service;

import java.util.List;


import hello.mapservice.exception.ResourceNotFoundException;
import hello.mapservice.model.Marker;
import hello.mapservice.repository.MarkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarkerService {

    @Autowired
    private MarkerRepository markerRepository;

    //get all marker
    @Transactional
    public List<Marker> getAllMarker() {
        return markerRepository.findAll();
    }

    //create marker
    @Transactional
    public Marker createMarker(Marker marker) {
        return markerRepository.save(marker);
    }

    //get marker by id
    @Transactional
    public Marker getMarker(Integer id) {
        Marker marker = markerRepository.findById(id).get();
        return marker;
    }

    //update marker by id
    @Transactional
    public ResponseEntity<Marker> updateMarker(Integer id, Marker updateMarker) {
        Marker marker =  markerRepository.findById(id).get();
        marker.setIsDanger(updateMarker.getIsDanger());
        marker.setMarkerInform(updateMarker.getMarkerInform());
        marker.setMarkerCategory(updateMarker.getMarkerCategory());
        marker.setImageUrl(updateMarker.getImageUrl());

        Marker endUpdatedMarker = markerRepository.save(marker);
        return ResponseEntity.ok(endUpdatedMarker);
    }

    public void deleteMarker(Integer id) {
        Marker marker = markerRepository.findById(id).get();
        markerRepository.delete(marker);
    }
}
