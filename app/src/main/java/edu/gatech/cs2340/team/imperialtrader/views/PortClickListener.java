package edu.gatech.cs2340.team.imperialtrader.views;

/**
 * Listener interface for port clicks
 */

interface PortClickListener {
    /**
     * Listener for toTradeClicked
     */
    void toTradeClicked();

    /**
     * Listener for onRefuelClicked
     */
    void onRefuelClicked();

    /**
     * Listener for onRepairClicked
     */
    void onRepairClicked();
}
