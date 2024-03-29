package com.sofka.model.mambu.retiro;

import lombok.Builder;

@Builder(toBuilder = true)
public class MambuTrxCnlCashDepFields {
    private String src_system_txn_id;
    private String src_system_ip;

    public MambuTrxCnlCashDepFields(){

    }

    public MambuTrxCnlCashDepFields(String src_system_txn_id, String src_system_ip) {
        this.src_system_txn_id = src_system_txn_id;
        this.src_system_ip = src_system_ip;
    }

    public String getSrc_system_txn_id() {
        return src_system_txn_id;
    }

    public void setSrc_system_txn_id(String src_system_txn_id) {
        this.src_system_txn_id = src_system_txn_id;
    }

    public String getSrc_system_ip() {
        return src_system_ip;
    }

    public void setSrc_system_ip(String src_system_ip) {
        this.src_system_ip = src_system_ip;
    }

    @Override
    public String toString() {
        return "TrxCnlCashDepFields{" +
                "src_system_txn_id=" + src_system_txn_id +
                ", src_system_ip='" + src_system_ip + '\'' +
                '}';
    }
}
