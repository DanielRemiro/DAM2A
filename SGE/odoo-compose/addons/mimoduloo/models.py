from odoo import models, fields,api
from odoo.exceptions import ValidationError
from datetime import datetime

class Alumno(models.Model):
    _name = 'mimodulo.alumno'
    _description = 'Alumno del módulo de ejemplo'

    name = fields.Char(string='Nombre', required=True)
    edad = fields.Integer(string='Edad',default=18)
    email = fields.Char(string='Correo Electrónico', compute='_compute_email')
    dni=fields.Char(string='DNI')

    curso_id=fields.Many2many('mimodulo.curso', string='Cursos Inscritos')
    examen_ids=fields.Many2many('mimodulo.examen', string='Exámenes Presentados')

    @api.constrains('edad')
    def _check_edad(self):
        for record in self:
            if record.edad < 0:
                raise ValidationError("La edad no puede ser negativa.")
            if record.edad < 18:
                raise ValidationError("Tiene que ser mayor de edad.")
    
    @api.depends('name', 'edad')
    def _compute_email(self):
        for record in self:
            if record.edad and record.name:
                record.email = f"{record.name.lower().replace(' ', '.')}@gmail.com"
            else:
                record.email = ''
    
    @api.constrains('dni')
    def _check_dni(self):
        for record in self:
            if record.dni and len(record.dni) != 9:
                raise ValidationError("El DNI debe tener 9 caracteres.")
    

class Curso(models.Model):
    _name = 'mimodulo.curso'
    _description = 'Curso del módulo de ejemplo'

    name = fields.Char(string='Título del Curso', required=True)
    descripcion = fields.Text(string='Descripción')
    duracion = fields.Integer(string='Duración (horas)')

    alumno_id=fields.Many2many('mimodulo.alumno', string='Alumnos Inscritos')

    @api.constrains('duracion')
    def _check_duracion(self):
        for record in self:
            if record.duracion <= 0:
                raise ValidationError("La duración del curso debe ser un número positivo.")
    
    
    

class Profesor(models.Model):
    _name = 'mimodulo.profesor'
    _description = 'Profesor del módulo de ejemplo'

    name = fields.Char(string='Nombre', required=True)
    especialidad = fields.Char(string='Especialidad')
    email = fields.Char(string='Correo Electrónico')
    sexo = fields.Selection([
        ('masculino', 'Masculino'),
        ('femenino', 'Femenino'),
        ('otro', 'Otro')
    ], string='Sexo')

    departamento_id=fields.Many2one('mimodulo.departamento', string='Departamento')

class Departamento(models.Model):
    _name = 'mimodulo.departamento'
    _description = 'Departamento del módulo de ejemplo'

    name = fields.Char(string='Nombre del Departamento', required=True)
    ubicacion = fields.Char(string='Ubicación')

    profesor_id=fields.One2many('mimodulo.profesor', 'departamento_id', string='Profesores del Departamento')

class Examen(models.Model):
    _name = 'mimodulo.examen'
    _description = 'Examen del módulo de ejemplo'

    name = fields.Char(string='Título del Examen', required=True)
    fecha = fields.Datetime(string='Fecha y Hora del Examen')

    alumno_id = fields.Many2many('mimodulo.alumno', string='Alumnos que Presentan el Examen')

    @api.constrains('fecha')
    def _check_fecha(self):
        for record in self:
            if record.fecha and record.fecha < datetime.now():
                raise ValidationError("La fecha del examen no puede ser en el pasado.")

