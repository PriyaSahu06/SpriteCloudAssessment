package enums;

public enum OrderStatus {

    PLACED {
        @Override
        public String toString() {
            return "placed";
        }
    },
    APPROVED {
        @Override
        public String toString() {
            return "approved";
        }
    },
    DELIVERED {
        @Override
        public String toString() {
            return "delivered";
        }
    }

}
