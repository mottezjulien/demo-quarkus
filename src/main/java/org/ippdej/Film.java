package org.ippdej;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Film", description="Representation of a Film")
public class Film {

        @Schema(title = "Film title", required = false)
        private String title;

        @Schema(title = "Film short description", required = false)
        private String synopsis;

        public Film() {
        }

        public Film(String title, String synopsis) {
                this.title = title;
                this.synopsis = synopsis;
        }

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
