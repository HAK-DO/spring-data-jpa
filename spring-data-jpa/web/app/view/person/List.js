Ext.define('MyApp.view.person.List', {
    extend:'Ext.grid.Panel',
    alias:'widget.personlist',
    title:'All People',
    store:'People',

    initComponent:function ()
    {
        console.log("{MyApp.view.person.List} init person.List view");

        this.columns = [
            {header:'ID', dataIndex:'id', flex:1},
            {header:'First Name', dataIndex:'firstName', flex:1},
            {header:'Middle Name', dataIndex:'middleName', flex:1},
            {header:'Last Name', dataIndex:'lastName', flex:1}
        ];

        this.buttons = [
            {
                text:'Add Person',
                action:'add'
            },{
            	text:'Edit Person',
            	action:'edit'
            },{
	            text:'Delete Person',
	            action:'delete'
            }
        ];

        this.callParent(arguments);
    }
});