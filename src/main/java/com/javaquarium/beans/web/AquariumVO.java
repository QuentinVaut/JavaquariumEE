package com.javaquarium.beans.web;

import java.util.List;

/**
 * Created by quentin on 17/02/2017.
 */
public class AquariumVO {

    private List<PoissonVO> lstPoissonsAquarium;

    public List<PoissonVO> getLstPoissonsAquarium() {
        return lstPoissonsAquarium;
    }

    public void setLstPoissonsAquarium(List<PoissonVO> lstPoissonsAquarium) {
        this.lstPoissonsAquarium = lstPoissonsAquarium;
    }
}
