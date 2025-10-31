# -*- coding: utf-8 -*-
{
	'name': "course",
    'summary': """examen odoo""",
    'description': "my first module in odoo 19 -",
    'author': "Daniel",
    'website': "http://www.iespabloserrano.com",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/master/openerp/addons/base/module/module_data.xml
    # for the full list
    'category': 'odoo',
    'version': '0.1',

    # any module necessary for this one to work correctly
    # 'depends': ['base'],

    # always loaded
    'data': [
        'views.xml',
	# 'vistas/matches.xml',
	# 'vistas/maps.xml',
	# 'vistas/characters.xml',
    ],
}