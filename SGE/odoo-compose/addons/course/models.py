# -*- coding: utf-8 -*-

from odoo import models, fields, api

class Course(models.Model):
    _name = 'course.course'
    _description = 'Me encanta ODOO'

    name = fields.Char(string='Course Name', required=True)
    description = fields.Text(string='Description')
    duration = fields.Integer(string='Duration (hours)')
    active = fields.Boolean(string='Active', default=True)
 