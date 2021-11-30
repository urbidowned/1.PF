package Urban.Projekt;

import java.util.Date;

public class Exchange {

        private final Date datum;
        private final String content;

        public Exchange(Date d, String s) {
            this.content = s;
            this.datum = d;

        }

        public String getContent() {
            return this.content;
        }
    }

