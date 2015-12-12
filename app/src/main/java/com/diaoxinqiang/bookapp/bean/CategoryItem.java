package com.diaoxinqiang.bookapp.bean;

public  class CategoryItem {
        private String id;
        private String catalog;

        public void setId(String id) {
            this.id = id;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getId() {
            return id;
        }

        public String getCatalog() {
            return catalog;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id='" + id + '\'' +
                    ", catalog='" + catalog + '\'' +
                    '}';
        }
    }