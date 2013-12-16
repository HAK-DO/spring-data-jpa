/**
 * Store for managing staff
 */
Ext.define('CarTracker.store.Staff', {
	extend: 'CarTracker.store.Base',
    alias: 'store.staff',
    requires: [
        'CarTracker.model.Staff'
    ],
    restPath: '/account',
    storeId: 'Staff',
    model: 'CarTracker.model.Staff'
});