from odoo import models, fields,api
from odoo.exceptions import ValidationError
from datetime import datetime

class Persona(models.Model):
    _name = 'padre.persona'
    _description = 'Persona del módulo padre'

    name = fields.Char(string='Nombre', required=True)
    edad = fields.Integer(string='Edad',default=0)
