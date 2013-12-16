Ext.define('MyApp.view.person.Edit', {
    extend:'Ext.window.Window',
    alias:'widget.personedit',

    title:'Edit Person',
    layout:'fit',
    autoShow:true,

    initComponent:function ()
    {
        this.items = [
            {
                xtype:'form',
                bodyPadding : 5,
                items:[
                    {
                        xtype:'textfield',
                        name:'firstName',
                        fieldLabel:'First Name'
                    },
                    {
                    	xtype:'textfield',
                    	name:'middleName',
                    	fieldLabel:'Middle Name'
                    },
                    {
                        xtype:'textfield',
                        name:'lastName',
                        fieldLabel:'Last Name'
                    },
                    {
                        xtype:'hidden',
                        name:'id',
                        fieldLabel:'id'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text:'Update',
                action:'update'
            },
            {
                text:'Cancel',
                scope:this,
                handler:this.close
            }
        ];

        this.callParent(arguments);
    }
});