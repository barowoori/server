package com.barowoori.foodpinbackend.truck.command.domain.repository.dto;

import com.barowoori.foodpinbackend.document.command.domain.model.DocumentType;
import com.barowoori.foodpinbackend.truck.command.domain.model.Truck;
import com.barowoori.foodpinbackend.truck.command.domain.model.TruckPhoto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TruckList {
        private String id;
        private String name;
        private List<DocumentType> documents;
        private List<String> regions;
        private List<String> menuNames;
        private Photo photo;

        public static TruckList of(Truck truck, List<DocumentType> documents, List<String> regions, List<String> truckMenuNames) {

            return TruckList.builder()
                    .id(truck.getId())
                    .name(truck.getName())
                    .documents(documents)
                    .regions(regions)
                    .menuNames(truckMenuNames)
                    .photo(truck.getPhotos()
                            .stream()
                            .map(Photo::ofTruckPhoto)
                            .findFirst().orElse(null))
                    .build();
        }

        @Getter
        @Builder
        public static class Photo {
            private String id;
            private String path;

            public static Photo ofTruckPhoto(TruckPhoto truckPhoto) {
                return Photo.builder()
                        .id(truckPhoto.getId())
                        .path(truckPhoto.getFile().getPath())
                        .build();
            }
        }
}
