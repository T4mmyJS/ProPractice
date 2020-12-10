package dev.tomstar.ProPractice.handlers;

import dev.tomstar.ProPractice.practice.PracticeParty;
import dev.tomstar.ProPractice.practice.PracticePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartyHandler {

    private final List<PracticeParty> parties;

    public PartyHandler() {
        this.parties = new ArrayList<>();
    }

    public PracticeParty addParty() {
        PracticeParty party = new PracticeParty();
        parties.add(party);

        return party;
    }

    public void removeParty(PracticeParty party) {
        parties.remove(party);
    }

    public PracticeParty getParty(PracticePlayer player) {
        Optional<PracticeParty> party = parties.stream().filter(practiceParty -> practiceParty.hasMember(player)).findAny();
        return party.orElse(null);
    }

}
