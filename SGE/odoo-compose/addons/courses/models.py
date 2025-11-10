# -*- coding: utf-8 -*-

from odoo import models, fields, api

class Course(models.Model):
    _name = 'courses.course'
    _description = 'Course'

    name = fields.Char(string='Course Name', required=True)
    description = fields.Text(string='Description')
    duration = fields.Integer(string='Duration (hours)')
    active = fields.Boolean(string='Active', default=True)
 