package org.ippdej;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
public class FilmEntity extends PanacheEntity {

        private String title;

        private String synopsis;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getSynopsis() {
                return synopsis;
        }

        public void setSynopsis(String synopsis) {
                this.synopsis = synopsis;
        }
}
