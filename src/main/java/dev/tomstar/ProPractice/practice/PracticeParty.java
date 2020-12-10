package dev.tomstar.ProPractice.practice;

import dev.tomstar.ProPractice.states.MemberState;
import dev.tomstar.ProPractice.states.PartyState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeParty {

    private PartyState state;
    private final Map<PracticePlayer, MemberState> members;

    public PracticeParty() {
        this.state = PartyState.ONLINE;
        this.members = new HashMap<>();
    }

    public PartyState getState() {
        return state;
    }

    public void setState(PartyState state) {
        this.state = state;
    }

    public MemberState getMemberState(PracticePlayer player) {
        return members.get(player);
    }

    public void setMemberState(PracticePlayer player, MemberState state) {
        members.put(player, state);
    }

    public List<PracticePlayer> getMembers() {
        return new ArrayList<>(members.keySet());
    }

    public boolean hasMember(PracticePlayer player) {
        return members.containsKey(player);
    }

}
