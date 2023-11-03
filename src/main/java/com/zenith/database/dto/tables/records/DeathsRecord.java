/*
 * This file is generated by jOOQ.
 */
package com.zenith.database.dto.tables.records;


import com.zenith.database.dto.tables.Deaths;
import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.TableRecordImpl;

import java.time.OffsetDateTime;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DeathsRecord extends TableRecordImpl<DeathsRecord> implements Record8<OffsetDateTime, String, String, UUID, String, UUID, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.deaths.time</code>.
     */
    public DeathsRecord setTime(OffsetDateTime value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.time</code>.
     */
    public OffsetDateTime getTime() {
        return (OffsetDateTime) get(0);
    }

    /**
     * Setter for <code>public.deaths.death_message</code>.
     */
    public DeathsRecord setDeathMessage(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.death_message</code>.
     */
    public String getDeathMessage() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.deaths.victim_player_name</code>.
     */
    public DeathsRecord setVictimPlayerName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.victim_player_name</code>.
     */
    public String getVictimPlayerName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.deaths.victim_player_uuid</code>.
     */
    public DeathsRecord setVictimPlayerUuid(UUID value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.victim_player_uuid</code>.
     */
    public UUID getVictimPlayerUuid() {
        return (UUID) get(3);
    }

    /**
     * Setter for <code>public.deaths.killer_player_name</code>.
     */
    public DeathsRecord setKillerPlayerName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.killer_player_name</code>.
     */
    public String getKillerPlayerName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.deaths.killer_player_uuid</code>.
     */
    public DeathsRecord setKillerPlayerUuid(UUID value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.killer_player_uuid</code>.
     */
    public UUID getKillerPlayerUuid() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.deaths.weapon_name</code>.
     */
    public DeathsRecord setWeaponName(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.weapon_name</code>.
     */
    public String getWeaponName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.deaths.killer_mob</code>.
     */
    public DeathsRecord setKillerMob(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.deaths.killer_mob</code>.
     */
    public String getKillerMob() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<OffsetDateTime, String, String, UUID, String, UUID, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<OffsetDateTime, String, String, UUID, String, UUID, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<OffsetDateTime> field1() {
        return Deaths.DEATHS.TIME;
    }

    @Override
    public Field<String> field2() {
        return Deaths.DEATHS.DEATH_MESSAGE;
    }

    @Override
    public Field<String> field3() {
        return Deaths.DEATHS.VICTIM_PLAYER_NAME;
    }

    @Override
    public Field<UUID> field4() {
        return Deaths.DEATHS.VICTIM_PLAYER_UUID;
    }

    @Override
    public Field<String> field5() {
        return Deaths.DEATHS.KILLER_PLAYER_NAME;
    }

    @Override
    public Field<UUID> field6() {
        return Deaths.DEATHS.KILLER_PLAYER_UUID;
    }

    @Override
    public Field<String> field7() {
        return Deaths.DEATHS.WEAPON_NAME;
    }

    @Override
    public Field<String> field8() {
        return Deaths.DEATHS.KILLER_MOB;
    }

    @Override
    public OffsetDateTime component1() {
        return getTime();
    }

    @Override
    public String component2() {
        return getDeathMessage();
    }

    @Override
    public String component3() {
        return getVictimPlayerName();
    }

    @Override
    public UUID component4() {
        return getVictimPlayerUuid();
    }

    @Override
    public String component5() {
        return getKillerPlayerName();
    }

    @Override
    public UUID component6() {
        return getKillerPlayerUuid();
    }

    @Override
    public String component7() {
        return getWeaponName();
    }

    @Override
    public String component8() {
        return getKillerMob();
    }

    @Override
    public OffsetDateTime value1() {
        return getTime();
    }

    @Override
    public String value2() {
        return getDeathMessage();
    }

    @Override
    public String value3() {
        return getVictimPlayerName();
    }

    @Override
    public UUID value4() {
        return getVictimPlayerUuid();
    }

    @Override
    public String value5() {
        return getKillerPlayerName();
    }

    @Override
    public UUID value6() {
        return getKillerPlayerUuid();
    }

    @Override
    public String value7() {
        return getWeaponName();
    }

    @Override
    public String value8() {
        return getKillerMob();
    }

    @Override
    public DeathsRecord value1(OffsetDateTime value) {
        setTime(value);
        return this;
    }

    @Override
    public DeathsRecord value2(String value) {
        setDeathMessage(value);
        return this;
    }

    @Override
    public DeathsRecord value3(String value) {
        setVictimPlayerName(value);
        return this;
    }

    @Override
    public DeathsRecord value4(UUID value) {
        setVictimPlayerUuid(value);
        return this;
    }

    @Override
    public DeathsRecord value5(String value) {
        setKillerPlayerName(value);
        return this;
    }

    @Override
    public DeathsRecord value6(UUID value) {
        setKillerPlayerUuid(value);
        return this;
    }

    @Override
    public DeathsRecord value7(String value) {
        setWeaponName(value);
        return this;
    }

    @Override
    public DeathsRecord value8(String value) {
        setKillerMob(value);
        return this;
    }

    @Override
    public DeathsRecord values(OffsetDateTime value1, String value2, String value3, UUID value4, String value5, UUID value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeathsRecord
     */
    public DeathsRecord() {
        super(Deaths.DEATHS);
    }

    /**
     * Create a detached, initialised DeathsRecord
     */
    public DeathsRecord(OffsetDateTime time, String deathMessage, String victimPlayerName, UUID victimPlayerUuid, String killerPlayerName, UUID killerPlayerUuid, String weaponName, String killerMob) {
        super(Deaths.DEATHS);

        setTime(time);
        setDeathMessage(deathMessage);
        setVictimPlayerName(victimPlayerName);
        setVictimPlayerUuid(victimPlayerUuid);
        setKillerPlayerName(killerPlayerName);
        setKillerPlayerUuid(killerPlayerUuid);
        setWeaponName(weaponName);
        setKillerMob(killerMob);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised DeathsRecord
     */
    public DeathsRecord(com.zenith.database.dto.tables.pojos.Deaths value) {
        super(Deaths.DEATHS);

        if (value != null) {
            setTime(value.getTime());
            setDeathMessage(value.getDeathMessage());
            setVictimPlayerName(value.getVictimPlayerName());
            setVictimPlayerUuid(value.getVictimPlayerUuid());
            setKillerPlayerName(value.getKillerPlayerName());
            setKillerPlayerUuid(value.getKillerPlayerUuid());
            setWeaponName(value.getWeaponName());
            setKillerMob(value.getKillerMob());
            resetChangedOnNotNull();
        }
    }
}
