from odoo import models, fields,api

class Estudiante(models.Model):
    _inherit = 'padre.persona'
    _description = 'Estudiante del módulo hijo'

    matricula = fields.Char(string='Matrícula', required=True)
    carrera = fields.Char(string='Carrera')

class Trabajador(models.Model):
    
    _inherit = 'padre.persona'
    _name='hijo.trabajador'
    _description = 'Trabajador del módulo hijo'

    puesto = fields.Char(string='Puesto', required=True)
    fecha_contratacion = fields.Date(string='Fecha de Contratación', default=fields.Date.context_today)
